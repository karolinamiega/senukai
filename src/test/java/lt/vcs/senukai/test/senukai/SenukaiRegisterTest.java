package lt.vcs.senukai.test.senukai;

import lt.vcs.senukai.page.senukai.*;
import lt.vcs.senukai.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SenukaiRegisterTest extends TestBase {
    @BeforeMethod
    @Override

    public void initializeDriver() {
        super.initializeDriver();
        SenukaiRegistrationPage.open();
    }

    @Test
    public void testSenukaiRegistracijaCorrectDetails() {
        String name = "Demo";
        String surname = "Testavimui";
        String email = "demotestavimui@gmail.com";
        String password = "VCSDemo@123";

        String expectedUrl = "https://www.senukai.lt/users/confirmation/wait";
        String expectedMessage = "Netrukus el.paštu gausi paskyros aktyvavimo nuorodą. Sek instrukcijas el.pašte ir aktyvuok savo SMART NET paskyrą.";
        String expectedTitle = "Senukai.lt - Paskyros aktyvavimas";


        SenukaiCookiesHandler.clickOnButtonConfirmAll();

        SenukaiRegistrationPage.clickOnButtonLogin();
        SenukaiRegistrationPage.clickOnButtonRegister();
        SenukaiRegistrationPage.scrollDownActions();

        SenukaiRegistrationPage.enterNameToRegister(name);
        SenukaiRegistrationPage.enterSurnameToRegister(surname);
        SenukaiRegistrationPage.enterEmailToRegister(email);
        SenukaiRegistrationPage.enterPasswordToRegister(password);
        SenukaiRegistrationPage.repeatPasswordToRegister(password);

        SenukaiRegistrationPage.submitYourInputToRegister();

        String actualUrl = SenukaiAfterRegistrationPage.checkUrl();
        String actualMessage = SenukaiAfterRegistrationPage.checkMessage();
        String actualTitle = SenukaiAfterRegistrationPage.checkTitle();

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testSenukaiRegistracijaInvalidEmail() {
        String name = "Demo";
        String surname = "Testavimui";
        String invalidEmail = "demotestavimuigmailcom";
        String password = "VCSDemo@123";

        SenukaiCookiesHandler.clickOnButtonConfirmAll();

        SenukaiRegistrationPage.clickOnButtonLogin();
        SenukaiRegistrationPage.clickOnButtonRegister();
        SenukaiRegistrationPage.scrollDownActions();

        SenukaiRegistrationPage.enterNameToRegister(name);
        SenukaiRegistrationPage.enterSurnameToRegister(surname);
        SenukaiRegistrationPage.enterEmailToRegister(invalidEmail);
        SenukaiRegistrationPage.enterPasswordToRegister(password);
        SenukaiRegistrationPage.repeatPasswordToRegister(password);

        SenukaiRegistrationPage.submitYourInputToRegister();


        String actualErrorMessage = SenukaiRegistrationPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Prašom įvesti teisingą el.paštą");

    }
}







