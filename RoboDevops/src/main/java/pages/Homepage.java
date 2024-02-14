package pages;

import org.openqa.selenium.By;
import utilities.TestContext;

public class Homepage {

    By homeProjectsMenu = By.xpath("//a[@class='MuiButtonBase-root css-q6ggza']/span[contains(text(), 'Projects')]");
    By homeTenantsMenu = By.xpath("//a[@class='MuiButtonBase-root css-q6ggza']/span[contains(text(), 'Tenants')]");

    TestContext testContext;

    public Homepage(TestContext testContext) {
        this.testContext = testContext;
        System.out.println("From Home page");
    }
}
