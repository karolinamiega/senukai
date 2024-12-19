package lt.vcs.senukai.test.senukai;

import lt.vcs.senukai.page.senukai.*;
import lt.vcs.senukai.test.TestBase;
import lt.vcs.senukai.util.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SenukaiLoginTest extends TestBase {
    @BeforeMethod
    @Override
    public void initializeDriver() {
        super.initializeDriver();
        SenukaiLoginPage.open();
    }


    @Test
    public void testSenukaiPrisijungimas() {
        String email = "demotestavimui@gmail.com";
        String password = "VCSDemo@123";

        String expectedMessage = "Sveiki,\n" + "Demo";

        SenukaiLoginPage.clickOnButtonLogin();
        SenukaiLoginPage.enterEmail(email);
        SenukaiLoginPage.enterPassword(password);
        SenukaiCookiesHandler.clickOnButtonConfirmAll();
        SenukaiLoginPage.submitYourInput();

        String actualMessage = SenukaiAfterEmailConfirmationPage.checkMessage().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "The welcome message is not as expected. Actual: " + actualMessage + ", Expected: " + expectedMessage);

        WebElement actualCondition = SenukaiAfterEmailConfirmationPage.lookForGreenBubble();
        Assert.assertTrue(actualCondition.isDisplayed(), "The green bubble indicating a successful login is not displayed.");

    }
}
