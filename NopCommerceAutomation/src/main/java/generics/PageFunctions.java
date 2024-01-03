package generics;

import config.ConfigFactory;
import constants.Constants;
import driverfactory.DriverFactory;
import enums.WaitStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static enums.WaitStrategy.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class PageFunctions {
//    static WebDriver driver = DriverFactory.getDriver();

    public static boolean _isDisplayed(By by, String eleName) {
        return true;
    }

    public static void _loadURL(String url) {
        DriverFactory.getDriver().get(url);
    }

    public static WebDriverWait _getWebDriverWait(long seconds) {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(seconds));
    }


    /**
     * This methods clears the WebElement Field and Fill the specified value
     *
     * @param by
     * @param text
     */
    public static void _clearAndSendKeys(By by, String text, String eleName) {
        WebElement webElement;
        try {
            webElement = _performExplicitWait(by, NONE);
//            String os = System.getProperty("os.name");
            webElement.sendKeys(Keys.COMMAND + "a");
            webElement.sendKeys(Keys.DELETE);
            webElement.sendKeys(text);
        } catch (StaleElementReferenceException ex) {
            webElement = _performExplicitWait(by, HANDLESTALE);
            webElement.click();
            webElement.clear();
            webElement.sendKeys(text);
        }
    }

    public static WebElement _performExplicitWait(By by, WaitStrategy waitStrategy) {
        WebElement e = null;
        WebDriverWait wait = _getWebDriverWait(Constants.DEFAULT_WEBDRIVERWAIT);
        try {
            switch (waitStrategy) {
                case NONE:
                    e = DriverFactory.getDriver().findElement(by);
                    break;
                case VISIBLE:
                    e = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
                    break;
                case CLICKABLE:
                    e = wait.until(ExpectedConditions.elementToBeClickable(by));
                    break;
                case PRESENCE:
                    e = wait.until(ExpectedConditions.presenceOfElementLocated(by));
                    break;
            }
        } catch (Exception exception) {
            throw exception;
        }
        return e;
    }

    public static List<WebElement> _performExplicitWaitForElements(By by, WaitStrategy waitStrategy) {
        List<WebElement> elements = null;
        WebDriverWait wait = _getWebDriverWait(Constants.DEFAULT_WEBDRIVERWAIT);
        try {
            switch (waitStrategy) {
                case NONE:
                    elements = DriverFactory.getDriver().findElements(by);
                    break;
                case VISIBLE:
                    elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
                    break;
                case CLICKABLE:
                    elements = wait.until(d -> d.findElements(by).stream().filter(WebElement::isEnabled).collect(Collectors.toList()));
                    break;
                case PRESENCE:
                    elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                    break;
                case HANDLESTALE:
                    elements = wait.until(d -> {
                        d.navigate().refresh();
                        return d.findElements(by);
                    });
                    break;
            }
        } catch (Exception exception) {
            throw exception;
        }
        return elements;
    }


    public static List<WebElement> _performExplicitWaitForColumnElements(WebElement rowElement, By by, WaitStrategy waitStrategy) {
        List<WebElement> elements = null;
        WebDriverWait wait = _getWebDriverWait(Constants.DEFAULT_WEBDRIVERWAIT);
        try {
            switch (waitStrategy) {
                case NONE:
                    elements = DriverFactory.getDriver().findElements(by);
                    break;
                case VISIBLE:
                    elements = wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(rowElement, by));
                    break;
//                case CLICKABLE:
//                    elements = wait.until(d -> d.findElements(by).stream().filter(WebElement::isEnabled).collect(Collectors.toList()));
//                    break;
//                case PRESENCE:
//                    elements = wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(rowElement, by));
//                    break;
                case HANDLESTALE:
                    elements = wait.until(d -> {
                        d.navigate().refresh();
                        return d.findElements(by);
                    });
                    break;
            }
        } catch (Exception exception) {
            throw exception;
        }
        return elements;
    }

    /**
     * Returns the List of WebElements
     *
     * @param by
     * @return List<WebElement>
     */
    public static List<WebElement> _getElements(By by, String eleListName) {
        List<WebElement> elements;
        try {
            elements = _performExplicitWaitForElements(by, VISIBLE);
        } catch (StaleElementReferenceException e) {
            elements = _performExplicitWaitForElements(by, HANDLESTALE);
        }
//        if (!eleListName.isEmpty()) Logger.info(String.format("Elements: %s, found: %s", eleListName, elements.size()));
        return elements;
    }

    /**
     * Returns the Texts as List for All displayed Elements
     *
     * @param by
     * @return String list
     */
    public static List<String> _getAllDisplayedElementsText(By by) {
        List<String> allDisplayedEleText = new ArrayList<>();
        for (WebElement webElement : _getElements(by, "")) {
            if (webElement.isDisplayed())  allDisplayedEleText.add(webElement.getText().trim().split("\n", 2)[0].substring(5));
        }
        return allDisplayedEleText;
    }

    /**
     * This method waits for the element to be clickable and clicks      *
     * @param by
     */
    public static void _click(By by, String elementName) {
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        WebElement e = _performExplicitWait(by, PRESENCE);
        e.click();
//        if (!elementName.isEmpty()) Logger.info("Clicked on " + elementName);
    }

    public static boolean _isElementAvailable(By by){
       if (DriverFactory.getDriver().findElement(by).isDisplayed()){
        return true;
       }else{
           return  false;
        }

    }

    public static void _checkBox_check(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement e = _performExplicitWait(by, waitStrategy);
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", e);
        if (!e.isSelected()) e.click();
    }

    public static void _checkBox_uncheck(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement e = _performExplicitWait(by, waitStrategy);
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", e);
        if (e.isSelected()) e.click();
    }

    /**
     * Selects the values from dropdown
     *
     * @param by:
     * @param value:
     */
    public static void _select_ByValue(By by, String value, String eleName) {
        WebElement element;
        try {
            element = _performExplicitWait(by, CLICKABLE);
            new Select(element).selectByValue(value);
        } catch (StaleElementReferenceException e) {
            element = _performExplicitWait(by, HANDLESTALE);
            new Select(element).selectByValue(value);
        }
    }

    /**
     * Selects the visible text option from dropdown
     *
     * @param by:
     * @param value:
     */
    public static void _select_ByVisibleText(By by, String value, String eleName) {
        WebElement element;
        try {
            element = _performExplicitWait(by, CLICKABLE);
            new Select(element).selectByVisibleText(value);
        } catch (StaleElementReferenceException e) {
            element = _performExplicitWait(by, HANDLESTALE);
            new Select(element).selectByVisibleText(value);
        }
    }

    public static void _clickByJavascriptExecutor(By by, WaitStrategy waitStrategy){
       WebElement element =  _performExplicitWait(by, waitStrategy);
        JavascriptExecutor jse = (JavascriptExecutor)DriverFactory.getDriver();
        jse.executeScript("arguments[0].click();", element);
    }


//    public void _setDate() throws InterruptedException {
//        // XPATHs of the elements
//        By calendar = By.xpath("//button[@aria-label='Open the date view']");
//        By previousButton = By.xpath("//a[@data-action='prev']");
//        By nextButton = By.xpath("//a[@data-action='next']");
//        By midButton = By.xpath("//a[@title='Navigate to year view']");
//        By allDates = By.xpath("//tbody[@class='k-calendar-tbody']/tr/td[not(contains(@class,'k-other-month'))]");
//        By allMonths = By.xpath("//table[contains(@class,'k-meta-view k-yea')]/tbody[@class='k-calendar-tbody']/tr/td[not(contains(@class,'k-other-month'))]");
//        By centerButton = By.xpath("//div[@class='k-header k-hstack']/a[contains(@class,'k-calendar-nav-fast')]");
//
//        // Elements
//        List<WebElement> allMonthsElements;
//        List<WebElement> allDatesElements;
//        WebElement calendarElement;
//        WebElement nextButtonElement;
//        WebElement previousButtonElement;
//        WebElement centerButtonElement;
//
//        String dateTime = "28/02/2023 2:00 PM";
//        DriverFactory.initDriver(ConfigFactory.getConfig().browser());
//        DriverFactory.getDriver().get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
//        calendarElement = PageFunctions._performExplicitWait(calendar, WaitStrategy.PRESENCE);
//        calendarElement.click();
////        Thread.sleep(1000);
//        centerButtonElement = PageFunctions._performExplicitWait(midButton, WaitStrategy.PRESENCE);
////        Thread.sleep(1000);
//        centerButtonElement.click();
//        String[] dateMonthYear = dateTime.split(" ")[0].split("/");
//        int yearDifferance = Integer.parseInt(dateMonthYear[2]) - Calendar.getInstance().get(Calendar.YEAR);
//        System.out.println(yearDifferance);
//        System.out.println(yearDifferance < 0);
//        if (yearDifferance != 0) {
//            if (yearDifferance > 0) {
//                for (int i = 1; i <= yearDifferance; i++) {
//                    nextButtonElement = PageFunctions._performExplicitWait(nextButton, WaitStrategy.PRESENCE);
//                    nextButtonElement.click();
//                }
//
//            } else {
//                for (int i = 1; i <= (yearDifferance * (-1)); i++) {
//                    previousButtonElement = PageFunctions._performExplicitWait(previousButton, WaitStrategy.PRESENCE);
//                    previousButtonElement.click();
//                }
//            }
//        }
//        try {
////            allMonthsElements = PageFunctions._performExplicitWaitForElements(allMonths, WaitStrategy.CLICKABLE);
////            allDatesElements = PageFunctions._performExplicitWaitForElements(allDates, WaitStrategy.CLICKABLE);
//
//            PageFunctions._performExplicitWaitForElements(allMonths, WaitStrategy.CLICKABLE).get(Integer.parseInt(dateMonthYear[1])-1).click();
//            Thread.sleep(1000);
//            PageFunctions._performExplicitWaitForElements(allDates, WaitStrategy.CLICKABLE).get(Integer.parseInt(dateMonthYear[0]) - 1).click();
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//
//
//    }

}


