package pages;

import constants.IUrlConstants;
import elements.Button;
import elements.DropDown;
import elements.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountModalPage extends BasePage implements IUrlConstants {

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Additional Information')]")
    WebElement additionalInformationHeader;

    /**
     * Open page new account modal page.
     *
     * @return the new account modal page
     */
    public NewAccountModalPage openPage() {
        driver.get(SALESFORCE_NEW_ACCOUNT_MODAL_PAGE_URL);
        return this;
    }

    /**
     * Wait for page loaded new account modal page.
     *
     * @return the new account modal page
     */
    public NewAccountModalPage waitForPageLoaded() {
        waitForElementLocated(additionalInformationHeader, 20);
        return this;
    }

    /**
     * Create.
     *
     * @param accountName    the account name
     * @param phone          the phone
     * @param website        the website
     * @param typeOption     the type option
     * @param industryOption the industry option
     */
    public void create(String accountName, String phone, String website, String typeOption, String industryOption) {
        new Input(driver, "Account Name").writeText(accountName);
        new Input(driver, "Phone").writeText(phone);
        new Input(driver, "Website").writeText(website);
        new DropDown(driver, "Type").select(typeOption);
        new DropDown(driver, "Industry").select(industryOption);
        clickSaveButton();
    }

    /**
     * Click save button.
     */
    public void clickSaveButton() {
        new Button(driver, "Save").clickButton();
    }
}