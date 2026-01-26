package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverfactory.DriverFactory;

public class ScreenshotUtil {

	public static String captureScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + testName + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));

            return path;
        } catch (Exception e) {
            throw new RuntimeException("Screenshot capture failed");
        }
    }
		
}
