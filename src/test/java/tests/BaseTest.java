package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.AccountListPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountModalPage;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    AccountListPage accountListPage;
    HomePage homePage;
    NewAccountModalPage newAccountModalPage;
    LoginPage loginPage;

    /**
     * Init test.
     * This method performed before the test method
     */
    @BeforeMethod
    public void InitTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initPages();
    }

    /**
     * End test.
     * This method performed after test method regardless of the test result
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    /**
     * Init pages.
     */
    public void initPages() {
        accountListPage = new AccountListPage(driver);
        homePage = new HomePage(driver);
        newAccountModalPage = new NewAccountModalPage(driver);
        loginPage = new LoginPage(driver);
    }
}