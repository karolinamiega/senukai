package lt.vcs.senukai.page;

import lt.vcs.senukai.util.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Common {

    public static void setUpChrome(int sec) {
        Driver.setChromeDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void close() {
        Driver.quitDriver();
    }

    private static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    public static void sendKeysToElement(By locator, String input) {
        getElement(locator).sendKeys(input);
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }


    public static void waitElementIsClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void scrollDownWithJS(By locator) {
        ((JavascriptExecutor) Driver.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public static void clickWithJS(By elementLocator) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", getElement(elementLocator));
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }


    public static void clickOnCookies(By locator) {
        WebElement button = Driver.getDriver().findElement(locator);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", button);
    }

    public static String getTabTitle() {
        return Driver.getDriver().getTitle();
    }

    public static String getCurrentUrl() {
        return Driver.getDriver().getCurrentUrl();
    }


    public static void disablePopups() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.open = function(){};");
        js.executeScript("window.alert = function(){};");
        js.executeScript("window.confirm = function() { return true; };");
    }

    public static void waitForInboxToLoad() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("#inbox"));
    }

    public static void waitElementIsVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement findElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    public static void acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
            System.out.println("Alert accepted");
        } catch (Exception e) {
            System.out.println("No alert to accept: " + e.getMessage());
        }
    }

    public static void inputEmailAndAcceptPrompt(String email) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = Driver.getDriver().switchTo().alert();

            alert.sendKeys(email);

            alert.accept();

            System.out.println("Email entered into the prompt and accepted.");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error during prompt handling: " + e.getMessage());
        }
    }

}

