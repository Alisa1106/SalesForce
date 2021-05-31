package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    /**
     * Create account test.
     * This method checks that account was create with correct account`s name and phone number.
     */
    @Test
    public void createAccountTest() {
        loginPage
                .openPage()
                .login(System.getProperty("username"), System.getProperty("password"));
        newAccountModalPage
                .openPage()
                .waitForPageLoaded()
                .create("FirstAccount", "+375290000000", "www.tut.by", "Customer", "Media");
        accountListPage
                .openPage()
                .waitForPageLoaded();
        Assert.assertEquals(accountListPage.getAccountName("FirstAccount"), "FirstAccount");
        Assert.assertEquals(accountListPage.getAccountPhoneNumber("+375290000000"), "+375290000000");
    }
}