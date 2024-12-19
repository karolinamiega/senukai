package lt.vcs.senukai.page.senukai;

import lt.vcs.senukai.page.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SenukaiAccountActivationPage {

    private static final By inputGmailEmail = By.xpath("//input[@type='email']");
    private static final By buttonNextEmailPage = By.xpath("(//div[@class='O1Slxf'])//button");
    private static final By inputGmailPassword = By.xpath("//input[@type='password']");
    private static final By buttonNextPasswordPage = By.xpath("//div[@jsname='DhK0U']//button");
    private static final By titleLatestEmail = By.xpath("(//span[@name='Senukai.lt'])[2]");
    private static final By buttonActivate = By.xpath("//a[contains(text(), 'Aktyvuoti paskyrą')]");



    public static void openGmail() {
       Common.openUrl("https://mail.google.com/mail/u/0/#inbox");
    }

    public static void inputEmail(String value) {
        Common.sendKeysToElement(inputGmailEmail, value);
    }

    public static void pressButtonNextEmailPage() {
        Common.waitElementIsClickable(buttonNextEmailPage, 7);
        Common.clickOnElement(buttonNextEmailPage);
    }

    public static void inputPassword(String value) {
        Common.waitElementIsVisible(inputGmailPassword, 7);
        Common.sendKeysToElement(inputGmailPassword, value);
    }

    public static void pressButtonNextPasswordPage() {
        Common.waitElementIsClickable(buttonNextPasswordPage, 7);
        Common.clickOnElement(buttonNextPasswordPage);
    }


    public static void openLatestEmail() {
        Common.waitElementIsVisible(titleLatestEmail, 7);
        Common.clickOnElement(titleLatestEmail);
    }

    public static void scrollDown() {
        Common.scrollDownWithJS(buttonActivate);
    }


        public static void pressButtonActivate() {
            WebElement activateButton = Common.findElement(buttonActivate);
            String activationUrl = activateButton.getAttribute("href");

            Common.openUrl(activationUrl);
        }
    }


