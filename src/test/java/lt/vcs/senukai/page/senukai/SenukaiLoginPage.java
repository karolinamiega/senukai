package lt.vcs.senukai.page.senukai;

import lt.vcs.senukai.page.Common;
import org.openqa.selenium.By;

public class SenukaiLoginPage {
    private static final By buttonLogin = By.xpath("//div[@class='user-block user-block--anonymous']");
    private static final By inputEmail = By.xpath("//input[@id='user_email']");
    private static final By inputPassword = By.xpath("//input[@id='user_password']");
    private static final By submitInputButton = By.xpath("//input[@value='Prisijungti']");

    public static void open() {
        Common.setUpChrome(10);
        Common.openUrl("https://www.senukai.lt/");
    }

    public static void clickOnButtonLogin() {
        Common.clickOnElement(buttonLogin);
    }

    public static void enterEmail(String value) {
        Common.sendKeysToElement(inputEmail, value);
    }

    public static void enterPassword(String value) {
        Common.sendKeysToElement(inputPassword, value);
    }

    public static void submitYourInput() {
        Common.clickOnElement(submitInputButton);
    }
}
