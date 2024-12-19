package lt.vcs.senukai.page.senukai;

import lt.vcs.senukai.page.Common;
import org.openqa.selenium.By;

public class SenukaiRegistrationPage {

    private static final By buttonLogin = By.xpath("//div[@class='user-block user-block--anonymous']");
    private static final By buttonRegister = By.xpath("(//p[@class='users-session-form__signup'])/a");

    private static final By inputRegistrationName = By.xpath("//input[@id='user_first_name']");
    private static final By inputRegistrationSurname = By.xpath("//input[@id='user_last_name']");
    private static final By inputEmail = By.xpath("//input[@id='user_email']");
    private static final By inputPassword = By.xpath("//input[@id='user_password']");
    private static final By repeatPassword = By.xpath("//input[@id='user_password_confirmation']");
    private static final By submitInputButton = By.xpath("//input[@value='Registruotis']");
    private static final By errorMessage = By.xpath("//p[@class='users-session-form__error-message']");

    public static void open() {
        Common.setUpChrome(10);
        Common.openUrl("https://www.senukai.lt/");
    }

    public static void clickOnButtonLogin() {
        Common.clickOnElement(buttonLogin);
    }
    public static void clickOnButtonRegister() {
        Common.waitElementIsClickable(buttonRegister, 10);
        Common.clickOnElement(buttonRegister);
    }

    public static void enterNameToRegister(String value) {
        Common.sendKeysToElement(inputRegistrationName, value);
    }

    public static void enterSurnameToRegister(String value) {

        Common.sendKeysToElement(inputRegistrationSurname, value);

    }

    public static void enterEmailToRegister(String value) {
        Common.sendKeysToElement(inputEmail, value);
    }

    public static void enterPasswordToRegister(String value) {
        Common.sendKeysToElement(inputPassword, value);

    }

    public static void repeatPasswordToRegister(String value) {
        Common.sendKeysToElement(repeatPassword, value);
    }

    public static void scrollDownActions(){
        Common.scrollDownWithJS(submitInputButton);
    }

    public static void submitYourInputToRegister() {
        Common.waitElementIsClickable(submitInputButton, 15);
        Common.clickOnElement(submitInputButton);
    }

    public static String getErrorMessage() {
        return Common.getTextFromElement(errorMessage);
    }
}
