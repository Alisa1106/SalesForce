package pages;

import constants.IUrlConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountListPage extends BasePage implements IUrlConstants {

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public static final String ACCOUNT_FIELD = "//table[contains(@class,'slds-table')]";
    public static final String ACCOUNT_NAME_FIELD = ACCOUNT_FIELD + "//*[contains(@title,'%s')]";
    public static final String ACCOUNT_PHONE_FIELD = ACCOUNT_FIELD + "//*[@class='enabledState']//*[contains(text(),'%s')]";

    @FindBy(xpath = "//table[ contains(@class,'slds-table')]")
    WebElement accountsTable;

    /**
     * Open page account list page.
     *
     * @return the account list page
     */
    public AccountListPage openPage() {
        driver.get(SALESFORCE_ACCOUNT_LIST_PAGE_URL);
        return this;
    }

    /**
     * Wait for page loaded account list page.
     *
     * @return the account list page
     */
    public AccountListPage waitForPageLoaded() {
        waitForElementLocated(accountsTable, 20);
        return this;
    }

    /**
     * Gets account name.
     *
     * @param name the name
     * @return the account name
     */
    public String getAccountName(String name) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_FIELD, name))).getText();
    }

    /**
     * Gets account phone number.
     *
     * @param phone the phone
     * @return the account phone number
     */
    public String getAccountPhoneNumber(String phone) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_PHONE_FIELD, phone))).getText();
    }
}