package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import utilities.TestContext;

import static generics.PageFunctions._performExplicitWait;

public class Homepage {

    By homeProjectsMenu = By.xpath("//a[@class='MuiButtonBase-root css-q6ggza']/span[contains(text(), 'Projects')]");
    By homeTenantsMenu = By.xpath("//a[@class='MuiButtonBase-root css-q6ggza']/span[contains(text(), 'Tenants')]");

    TestContext testContext;

    public Homepage(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From Home page");
    }

    public void clickTenatsMenu() {
        {
            _performExplicitWait(homeTenantsMenu, WaitStrategy.PRESENCE).click();
        }
    }
}
