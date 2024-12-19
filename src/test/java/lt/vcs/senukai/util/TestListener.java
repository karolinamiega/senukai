package lt.vcs.senukai.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result);
    }

    private void takeScreenshot(ITestResult result) {
        if (Driver.getDriver() == null) return;
        if (Driver.getDriver() instanceof TakesScreenshot screenshot) {

            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String formattedDateTime = LocalDateTime.now().format(formatter);

            String destFileName = "./screenshots/%s_%s_%s_screenshot.png".formatted(
                    formattedDateTime, result.getTestClass().getName(), result.getName()
            );

            File destFile = new File(destFileName);

            File parentDir = destFile.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException("Failed to save screenshot", e);
            }

        }
    }
}
