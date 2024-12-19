package lt.vcs.senukai.page.senukai;

import lt.vcs.senukai.page.Common;
import lt.vcs.senukai.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SenukaiCookiesHandler {
    public static final By confirmAllButton = By.xpath("//div[@id='cookie-btns']/a");

    public static void clickOnButtonConfirmAll() {
        Common.clickOnCookies(confirmAllButton);
    }

}
