package lt.vcs.senukai.page.senukai;

import lt.vcs.senukai.page.Common;
import org.openqa.selenium.By;

public class SenukaiDeleteAccountPage {

    private static final By accountLogoButton = By.xpath("//i[@class='user-block__icon icon-svg']");
    private static final By deleteAccountButton = By.xpath("//a[@id='delete-account-button']");
    private static final By h3ClassToBeScrolledTo = By.xpath("//h3[@class='profile-right-to-be-forgotten__title']");
    private static final By errorMessage = By.xpath("//p[@class='users-session-form__error-message']");

    public static void open() {
        Common.setUpChrome(10);
        Common.openUrl("https://www.senukai.lt/");
    }

    public static void clickOnMyProfile() {
        Common.clickOnElement(accountLogoButton);
    }


    public static void scrollAndClickWithAlertHandling() throws InterruptedException {
        Common.waitElementIsVisible(h3ClassToBeScrolledTo, 10);
        Common.scrollDownWithJS(h3ClassToBeScrolledTo);
        Thread.sleep(500);
        Common.clickOnElement(deleteAccountButton);
        Common.acceptAlert();
    }

    public static void inputEmail(String email) {
        Common.inputEmailAndAcceptPrompt(email);
    }

    public static String getErrorMessage() {
        return Common.getTextFromElement(errorMessage);
    }
}
