package lt.vcs.senukai.page.senukai;

import lt.vcs.senukai.page.Common;
import org.openqa.selenium.By;

public class SenukaiAfterRegistrationPage {
    private static final By message = By.xpath("//div[@class='users-confirmation__success-title']");

    public static String checkUrl() {
        return Common.getCurrentUrl();
    }

    public static String checkMessage() {
        return Common.getTextFromElement(message);
    }

    public static String checkTitle() {
        return Common.getTabTitle();
    }

}
