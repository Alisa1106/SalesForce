package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {

    WebDriver driver;
    String label;

    public static final String BUTTONS_XPATH = "//*[contains(@class,'button-container-inner')]/descendant::span[text()='%s']";

    public Button(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    /**
     * Click button.
     */
    public void clickButton() {
        driver.findElement(By.xpath(String.format(BUTTONS_XPATH, label))).click();
    }
}