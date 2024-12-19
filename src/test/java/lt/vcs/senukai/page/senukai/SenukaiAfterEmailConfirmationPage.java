package lt.vcs.senukai.page.senukai;

import lt.vcs.senukai.page.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SenukaiAfterEmailConfirmationPage {

    public static final By messageElement = By.xpath("//div[contains(text(), 'Sveiki,')]");
    public static final By greenBubble = By.xpath("//div[@class='user-block user-block--logged-in']");


    public static String checkMessage() {
        Common.waitElementIsVisible(messageElement, 10);
        return Common.getTextFromElement(messageElement);
    }

    public static WebElement lookForGreenBubble() {
        return Common.findElement(greenBubble);
    }
}
