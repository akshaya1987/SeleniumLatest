package pages;

import config.ConfigFactory;
import driverfactory.DriverFactory;
import enums.WaitStrategy;
import generics.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import utilities.TestContext;

import java.sql.Driver;
import java.util.List;

public class CustomerHomePage {

    By homePageCustomerName = By.xpath("//div[@class='pros-user-info']//div[contains(text(), 'Hindustan Australia In')]");
    By homePageServiceCenterOption = By.xpath("//div[@class='posb--app-scroll-container']//div[@class='posb--link-container']//div[contains(text(), 'Service Center')]");
    By homePageScitexServiceCenterOption = By.xpath("//div[@class='posb--group-options-container posb--floating']//a/div[contains(text(), 'Scitex Service Center')]");
    By homePageMediaLocatorOption = By.xpath("//div[@class='posb--app-scroll-container']//div[@class='posb--link-container']//div[contains(text(), 'Media Locator')]");
    By menuListItems = By.xpath("//div[@class='posb--app-scroll-container']//div[@class='posb--link-container']//div[@class='posb--name']");
    TestContext testContext;

    public CustomerHomePage(TestContext testContext) {
        this.testContext = testContext;
    }

    public boolean customerHomePageDisplayed() {
        return PageFunctions._isElementAvailable(homePageCustomerName, WaitStrategy.VISIBLE);
    }

    public void clickMenu() {
        PageFunctions._click(homePageCustomerName, "Menu button");
    }

    public void openScitexServiceCenter() {
        DriverFactory.getDriver().get(ConfigFactory.getConfig().scitex());
    }

 /*   public void clickScitexServiceCenterOption() {
        PageFunctions._click(homePageScitexServiceCenterOption, "scitex service center option");
        PageFunctions._clickByJavascriptExecutor(homePageScitexServiceCenterOption, WaitStrategy.VISIBLE);
    }
 */

}
