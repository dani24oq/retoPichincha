package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class GetScreenShot {

    public static void capture(WebDriver driver, String screenshotName) throws IOException {

        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "\\test-output\\" + screenshotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

    }
}
