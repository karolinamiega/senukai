package lt.vcs.senukai.test;

import lt.vcs.senukai.page.Common;
import lt.vcs.senukai.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class TestBase {

    protected WebDriver driver;

    public void initializeDriver() {
        if (driver == null) {
            Common.setUpChrome(7);
        }
    }

    @AfterMethod
    public void tearDown() {
        Common.close();
    }
}
