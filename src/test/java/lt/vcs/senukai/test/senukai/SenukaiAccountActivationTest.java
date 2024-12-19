package lt.vcs.senukai.test.senukai;

import lt.vcs.senukai.page.Common;
import lt.vcs.senukai.page.senukai.SenukaiAccountActivationPage;
import lt.vcs.senukai.page.senukai.SenukaiAfterEmailConfirmationPage;
import lt.vcs.senukai.test.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SenukaiAccountActivationTest extends TestBase {
    @BeforeMethod
    @Override
    public void initializeDriver() {
        super.initializeDriver();
        SenukaiAccountActivationPage.openGmail();
    }

    @Test
    public void testActivateAccount() {
        String email = "demotestavimui@gmail.com";
        String password = "VCSDemo@123";
        String expectedMessage = "Sveiki,\n" + "Demo";

        SenukaiAccountActivationPage.inputEmail(email);
        SenukaiAccountActivationPage.pressButtonNextEmailPage();
        SenukaiAccountActivationPage.inputPassword(password);
        SenukaiAccountActivationPage.pressButtonNextPasswordPage();

        Common.disablePopups();
        Common.waitForInboxToLoad();

        SenukaiAccountActivationPage.openLatestEmail();
        SenukaiAccountActivationPage.scrollDown();
        SenukaiAccountActivationPage.pressButtonActivate();


        String actualMessage = SenukaiAfterEmailConfirmationPage.checkMessage().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "The welcome message is not as expected. Actual: " + actualMessage + ", Expected: " + expectedMessage);

        WebElement actualCondition = SenukaiAfterEmailConfirmationPage.lookForGreenBubble();
        Assert.assertTrue(actualCondition.isDisplayed(), "The green bubble indicating a successful login is not displayed.");

    }
}
