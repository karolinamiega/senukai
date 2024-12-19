package lt.vcs.senukai.test.senukai;

import lt.vcs.senukai.page.senukai.SenukaiCookiesHandler;
import lt.vcs.senukai.page.senukai.SenukaiDeleteAccountPage;

import lt.vcs.senukai.page.senukai.SenukaiLoginPage;

import lt.vcs.senukai.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SenukaiDeleteAccountPageTest extends TestBase {
    @BeforeMethod
    @Override

    public void initializeDriver() {
        super.initializeDriver();
        SenukaiDeleteAccountPage.open();
    }

    @Test
    public void testDeleteAccount() throws InterruptedException {
        String email = "demotestavimui@gmail.com";
        String password = "VCSDemo@123";

        SenukaiLoginPage.clickOnButtonLogin();
        SenukaiLoginPage.enterEmail(email);
        SenukaiLoginPage.enterPassword(password);
        SenukaiCookiesHandler.clickOnButtonConfirmAll();
        SenukaiLoginPage.submitYourInput();


        SenukaiDeleteAccountPage.clickOnMyProfile();
        SenukaiDeleteAccountPage.scrollAndClickWithAlertHandling();
        SenukaiDeleteAccountPage.inputEmail(email);

        SenukaiLoginPage.clickOnButtonLogin();
        SenukaiLoginPage.enterEmail(email);
        SenukaiLoginPage.enterPassword(password);
        SenukaiLoginPage.submitYourInput();

        String actualErrorMessage = SenukaiDeleteAccountPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Neteisingai įvedėte savo el.paštą/slaptažodį arba jūsų slaptažodis nebegalioja");
    }
}
