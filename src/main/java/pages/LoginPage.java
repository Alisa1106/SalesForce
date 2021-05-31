package pages;

import constants.IUrlConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage implements IUrlConstants {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "Login")
    WebElement loginButton;

    /**
     * Open page login page.
     *
     * @return the login page
     */
    public LoginPage openPage() {
        driver.get(SALESFORCE_LOGIN_PAGE_URL);
        return this;
    }

    /**
     * Login home page.
     *
     * @param username the username
     * @param password the password
     * @return the home page
     */
    public HomePage login(String username, String password) {
        waitForElementLocated(usernameInput, 10);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new HomePage(driver);
    }
}