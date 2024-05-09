package pages;

import enums.WaitStrategy;
import generics.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.page.Page;
import utilities.TestContext;

public class PrintOSHomePage {
    By printOSHome = By.xpath("//div[@class='pros-breadcrumb-display']");
    By printOSHomeMenu = By.xpath("//div[@class='button-icon-container']");
    By printOSOrganizationDropdown = By.xpath("//div[@class='account-container']");
    By printOSOrganizationSearchField = By.xpath("//div[contains(@class, 'pros-options-search')]//div[contains(@class, 'pros-input-container')]/input");
    By printOSOrganizationName = By.xpath("//div[contains(text(), 'Hindustan Australia In')]");

    TestContext testContext;

    public PrintOSHomePage(TestContext testContext) {
        this.testContext = testContext;
    }

    public void clickMenu() {
        PageFunctions._performExplicitWait(printOSHomeMenu, WaitStrategy.VISIBLE).click();
    }

    public void clickOrganizationDropdown() {
        try {
            PageFunctions._performExplicitWait(printOSOrganizationDropdown, WaitStrategy.CLICKABLE).click();
        } catch (Exception e) {
            System.out.println("Organization is selected by default");
        }
    }

    public void enterOrganizationName() {
//      PageFunctions._performExplicitWait(printOSOrganizationSearchField, WaitStrategy.VISIBLE).sendKeys("Hindustan Australia In");
//      PageFunctions._sendKeysByJavascriptExecutor(printOSOrganizationSearchField, "organization search field", "Hindustan Australia In");
        try {
            PageFunctions.enterStringByCharacter(printOSOrganizationSearchField, "organization search field", "Hindustan");
        } catch (Exception e) {
            System.out.println("Organization is selected by default");
        }
    }

    public void selectOrganization() {
        PageFunctions._performExplicitWait(printOSOrganizationName, WaitStrategy.VISIBLE).click();
    }

}
