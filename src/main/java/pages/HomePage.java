package pages;

import constants.IUrlConstants;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage implements IUrlConstants {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page home page.
     *
     * @return the home page
     */
    public HomePage openPage() {
        driver.get(SALESFORCE_HOME_PAGE_URL);
        return this;
    }
}